import React, { useState, useEffect } from "react";
import { Contract } from "../../../types/Contract";
import Card from "../card";
import ContractTable from "../contractTable";
import { Stack } from "@mui/material";

interface ContractManagerProps {
  contracts: Contract[];
}

const ContractManager: React.FC<ContractManagerProps> = ({ contracts }) => {
  const [selectedContracts, setSelectedContracts] = useState<string[]>([]);
  const [sliderValue, setSliderValue] = useState<number>(0);
  const maxPayment = contracts.reduce(
    (sum, contract) =>
      sum + parseFloat(contract.payment.replace("$", "").replace(",", "")),
    0
  );

  useEffect(() => {
    const totalSelected = contracts
      .filter((contract) => selectedContracts.includes(contract.name))
      .reduce(
        (sum, contract) =>
          sum + parseFloat(contract.payment.replace("$", "").replace(",", "")),
        0
      );
    setSliderValue(totalSelected);
  }, [selectedContracts, contracts]);

  const handleContractSelect = (selectedContracts: string[]) => {
    setSelectedContracts(selectedContracts);
  };

  const handleSliderChange = (newValue: number) => {
    setSliderValue(newValue);
    let cumSum = 0;
    const newSelected = contracts
      .filter((contract) => {
        const payment = parseFloat(
          contract.payment.replace("$", "").replace(",", "")
        );
        if (cumSum + payment <= newValue) {
          cumSum += payment;
          return true;
        }
        return false;
      })
      .map((contract) => contract.name);
    setSelectedContracts(newSelected);
  };

  return (
    <Stack direction="row" spacing={3}>
      <ContractTable
        contracts={contracts}
        selectedContracts={selectedContracts}
        onContractSelect={handleContractSelect}
      />
      <Card
        value={sliderValue}
        max={maxPayment}
        onSliderChange={handleSliderChange}
        selectedContractsCount={selectedContracts.length}
      />
    </Stack>
  );
};

export default ContractManager;
