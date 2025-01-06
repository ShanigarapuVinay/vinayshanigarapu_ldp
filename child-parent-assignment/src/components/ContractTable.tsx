import React, { useState } from "react";
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Checkbox,
  Typography,
  Paper,
  Box,
  IconButton,
  Tooltip,
} from "@mui/material";
import MinusSquare from "@mui/icons-material/IndeterminateCheckBoxOutlined";
import InfoIcon from "@mui/icons-material/InfoOutlined";
import styled from "@emotion/styled";
import { Contract } from "../types/Contract";
import { contractHeadings } from "../types/ContractHeadings";

interface ContractTableProps {
  contracts: Contract[];
}

const ContractTable: React.FC<ContractTableProps> = ({ contracts }) => {
  const [selected, setSelected] = useState<string[]>([]);

  const handleSelect = (name: string) => {
    const selectedIndex = selected.indexOf(name);
    let newSelected: string[] = [];

    if (selectedIndex === -1) {
      newSelected = newSelected.concat(selected, name);
    } else if (selectedIndex === 0) {
      newSelected = newSelected.concat(selected.slice(1));
    } else if (selectedIndex === selected.length - 1) {
      newSelected = newSelected.concat(selected.slice(0, -1));
    } else if (selectedIndex > 0) {
      newSelected = newSelected.concat(
        selected.slice(0, selectedIndex),
        selected.slice(selectedIndex + 1)
      );
    }

    setSelected(newSelected);
  };

  const isSelected = (name: string) => selected.indexOf(name) !== -1;
  const StyledTableRow = styled(TableRow)(() => ({
    "&.Mui-selected, &.Mui-selected:hover": {
      backgroundColor: "#393552",
    },
    "&:hover": {
      backgroundColor: "#393552",
    },
  }));
  return (
    <Box
      sx={{
        padding: 5,
        backgroundColor: "#201F24",
        borderRadius: "12px",
        color: "#fff",
        width: "80%",
      }}
    >
      <Typography
        variant="h2"
        gutterBottom
        sx={{ fontSize: "24px", lineHeight: "29.4px", fontWeight: "600" }}
      >
        Your Contracts
        <Tooltip title="Information about your contracts">
          <IconButton size="medium" sx={{ marginLeft: 1, color: "#A5A5A6" }}>
            <InfoIcon fontSize="medium" />
          </IconButton>
        </Tooltip>
      </Typography>
      <TableContainer
        component={Paper}
        sx={{ backgroundColor: "#201F24", border: "none" }}
      >
        <Table>
          <TableHead sx={{ backgroundColor: "#262529" }}>
            <TableRow>
              <TableCell padding="checkbox" sx={{ borderBottom: "none" }}>
                <MinusSquare
                  sx={{ marginLeft: 1, marginTop: 1, color: "#727080" }}
                />
              </TableCell>
              {contractHeadings.map((item) => (
                <TableCell sx={{ borderBottom: "none" }}>
                  <Typography variant="body2" sx={{ color: "#A5A5A6" }}>
                    {item}
                  </Typography>
                </TableCell>
              ))}
            </TableRow>
          </TableHead>
          <TableBody>
            {contracts.map((contract) => {
              const isItemSelected = isSelected(contract.name);
              return (
                <StyledTableRow
                  key={contract.name}
                  hover
                  onClick={() => handleSelect(contract.name)}
                  role="checkbox"
                  aria-checked={isItemSelected}
                  selected={isItemSelected}
                  sx={{
                    cursor: "pointer",
                  }}
                >
                  <TableCell padding="checkbox" sx={{ borderBottom: "none" }}>
                    <Checkbox
                      checked={isItemSelected}
                      sx={{
                        color: "#727080",
                        "&.Mui-checked": {
                          color: "#B4A9FF",
                        },
                      }}
                    />
                  </TableCell>
                  <TableCell
                    component="th"
                    scope="row"
                    sx={{ borderBottom: "none" }}
                  >
                    <Typography
                      variant="body2"
                      sx={{ color: "#E8E7F0", fontSize: "14px" }}
                    >
                      {contract.name}
                    </Typography>
                  </TableCell>
                  <TableCell sx={{ borderBottom: "none" }}>
                    <Typography variant="body2" sx={{ color: "#A5A5A6" }}>
                      {contract.type}
                    </Typography>
                  </TableCell>
                  <TableCell sx={{ borderBottom: "none" }}>
                    <Typography variant="body2" sx={{ color: "#A5A5A6" }}>
                      {contract.perPayment}
                    </Typography>
                  </TableCell>
                  <TableCell sx={{ borderBottom: "none" }}>
                    <Typography variant="body2" sx={{ color: "#A5A5A6" }}>
                      {contract.termLength}
                      <br />
                      {contract.fee} fee
                    </Typography>
                  </TableCell>
                  <TableCell sx={{ borderBottom: "none" }}>
                    <Typography variant="body2" sx={{ color: "#A5A5A6" }}>
                      {contract.payment}
                    </Typography>
                  </TableCell>
                </StyledTableRow>
              );
            })}
          </TableBody>
        </Table>
      </TableContainer>
    </Box>
  );
};

export default ContractTable;
