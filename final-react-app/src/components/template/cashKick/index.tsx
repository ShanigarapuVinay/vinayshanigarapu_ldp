import WestIcon from "@mui/icons-material/West";
import { Box, Stack } from "@mui/material";
import React from "react";
import { Constants } from "../../../constants";
import { StyledCashKickBox } from "../../../helper/styledComponents";
import useContracts from "../../../hooks/useContracts";
import Button from "../../atoms/button";
import Header from "../../organisms/Header";
import ContractManager from "../../organisms/contractManager";
import NavBar from "../../organisms/navbar";
const CashKick: React.FC = () => {
  const { contracts } = useContracts();
  return (
    <Box>
      <Stack direction="row">
        <NavBar />
        <StyledCashKickBox>
          <Box sx={{ marginTop: "30px", marginLeft: "30px" }}>
            <Header />
          </Box>
          <Box sx={{ marginLeft: "30px", marginTop: "10px" }}>
            <Button variant="outlined" startIcon={<WestIcon />}>
              {Constants.BACK}
            </Button>
          </Box>
          <Box sx={{ marginLeft: "30px", marginTop: "30px" }}>
            <ContractManager contracts={contracts} />
          </Box>
        </StyledCashKickBox>
      </Stack>
    </Box>
  );
};

export default CashKick;
