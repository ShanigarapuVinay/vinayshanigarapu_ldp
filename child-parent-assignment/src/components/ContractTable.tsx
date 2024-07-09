import MinusSquare from "@mui/icons-material/IndeterminateCheckBoxOutlined";
import InfoIcon from "@mui/icons-material/InfoOutlined";
import {
  Box,
  Checkbox,
  IconButton,
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  ThemeProvider,
  Tooltip,
  Typography,
} from "@mui/material";
import React, { useState } from "react";
import theme from "../Helper/Theme";
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
  return (
    <ThemeProvider theme={theme}>
      <Box
        sx={{
          padding: 5,
          backgroundColor: "#201F24",
          borderRadius: "12px",
          color: "#fff",
          width: "80%",
        }}
      >
        <Typography variant="h2" gutterBottom>
          Your Contracts
          <Tooltip title="Information about your contracts">
            <IconButton size="medium">
              <InfoIcon fontSize="medium" />
            </IconButton>
          </Tooltip>
        </Typography>
        <TableContainer component={Paper}>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell padding="checkbox">
                  <MinusSquare
                    sx={{ marginLeft: 1, marginTop: 1, color: "#727080" }}
                  />
                </TableCell>
                {contractHeadings.map((item) => (
                  <TableCell>
                    <Typography variant="body2">{item}</Typography>
                  </TableCell>
                ))}
              </TableRow>
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
                    sx={{
                      cursor: "pointer",
                    }}
                  >
                    <TableCell padding="checkbox">
                      <Checkbox checked={isItemSelected} />
                    </TableCell>
                    <TableCell component="th" scope="row">
                      <Typography variant="body1">{contract.name}</Typography>
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
        </TableContainer>
      </Box>
    </ThemeProvider>
  );
};

export default ContractTable;
