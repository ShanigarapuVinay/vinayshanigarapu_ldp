import {
  Checkbox,
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow,
  ThemeProvider,
  Typography,
} from "@mui/material";
import React from "react";
import { Constants } from "../../../constants";
import {
  StyledContractContainer,
  StyledMinusSquare,
  StyledTableContainer,
  StyledTableRow,
} from "../../../helper/styledComponents";
import theme from "../../../helper/theme";
import { Contract } from "../../../types/Contract";
import { contractHeadings } from "../../../types/ContractHeadings";
import Icography from "../../molecules/icography";

interface ContractTableProps {
  contracts: Contract[];
  selectedContracts: string[];
  onContractSelect: (selected: string[]) => void;
}

const ContractTable: React.FC<ContractTableProps> = ({
  contracts,
  selectedContracts,
  onContractSelect,
}) => {
  const handleSelect = (name: string) => {
    const selectedIndex = selectedContracts.indexOf(name);
    let newSelected: string[] = [];

    if (selectedIndex === -1) {
      newSelected = newSelected.concat(selectedContracts, name);
    } else if (selectedIndex === 0) {
      newSelected = newSelected.concat(selectedContracts.slice(1));
    } else if (selectedIndex === selectedContracts.length - 1) {
      newSelected = newSelected.concat(selectedContracts.slice(0, -1));
    } else if (selectedIndex > 0) {
      newSelected = newSelected.concat(
        selectedContracts.slice(0, selectedIndex),
        selectedContracts.slice(selectedIndex + 1)
      );
    }

    onContractSelect(newSelected);
  };

  const isSelected = (name: string) => selectedContracts.indexOf(name) !== -1;

  return (
    <ThemeProvider theme={theme}>
      <StyledContractContainer>
        <Icography
          src={Constants.INFO}
          alt="Info"
          position="right"
          text="Your Contracts"
          variant="h3"
        />
        <StyledTableContainer>
          <Table>
            <TableHead>
              <StyledTableRow>
                <TableCell padding="checkbox">
                  <StyledMinusSquare />
                </TableCell>
                {contractHeadings.map((item) => (
                  <TableCell key={item}>
                    <Typography variant="body2">{item}</Typography>
                  </TableCell>
                ))}
              </StyledTableRow>
            </TableHead>
            <TableBody>
              {contracts.map((contract) => {
                const isItemSelected = isSelected(contract.name);
                return (
                  <TableRow
                    key={contract.name}
                    hover
                    onClick={() => handleSelect(contract.name)}
                    role="checkbox"
                    aria-checked={isItemSelected}
                    selected={isItemSelected}
                  >
                    <TableCell padding="checkbox">
                      <Checkbox checked={isItemSelected} />
                    </TableCell>
                    <TableCell component="th" scope="row">
                      <Typography variant="body2" color="#E8E7F0">
                        {contract.name}
                      </Typography>
                    </TableCell>
                    <TableCell>
                      <Typography variant="body2">{contract.type}</Typography>
                    </TableCell>
                    <TableCell>
                      <Typography variant="body2">
                        {contract.perPayment}
                      </Typography>
                    </TableCell>
                    <TableCell>
                      <Typography variant="body2">
                        {contract.termLength}
                        <br />
                        {contract.fee} fee
                      </Typography>
                    </TableCell>
                    <TableCell>
                      <Typography variant="body2">
                        {contract.payment}
                      </Typography>
                    </TableCell>
                  </TableRow>
                );
              })}
            </TableBody>
          </Table>
        </StyledTableContainer>
      </StyledContractContainer>
    </ThemeProvider>
  );
};

export default ContractTable;
