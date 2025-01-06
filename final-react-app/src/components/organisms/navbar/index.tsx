import { Box } from "@mui/material";
import React from "react";
import { Constants } from "../../../constants";
import {
  StyledBoxNavBar,
  StyledNavBar,
} from "../../../helper/styledComponents";
import Icography from "../../molecules/icography";

const NavBar: React.FC = () => {
  return (
    <StyledNavBar>
      <Icography
        src={Constants.LOGO}
        alt={Constants.LOGONAME}
        position="left"
        variant="h2"
        text={Constants.LOGONAME}
      />
      <Box sx={{ width: "210px", height: "543px", gap: "4px" }}>
        <StyledBoxNavBar>
          <Icography
            src={Constants.HOME}
            alt={Constants.HOMETEXT}
            position="left"
            variant="body1"
            text={Constants.HOMETEXT}
          />
        </StyledBoxNavBar>
        <StyledBoxNavBar sx={{ background: "#2D2D30", color: "#E8E7F0" }}>
          <Icography
            src={Constants.COIN}
            alt={Constants.CASH}
            position="left"
            variant="body1"
            text={Constants.CASH}
            color="#E8E7F0"
          />
        </StyledBoxNavBar>
      </Box>
      <StyledBoxNavBar>
        <Icography
          src={Constants.FLASH}
          alt={Constants.WATCH}
          position="left"
          variant="body1"
          text={Constants.WATCH}
        />
      </StyledBoxNavBar>
    </StyledNavBar>
  );
};

export default NavBar;
