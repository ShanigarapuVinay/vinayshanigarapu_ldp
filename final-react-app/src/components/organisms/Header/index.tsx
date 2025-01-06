import { useAuth0 } from "@auth0/auth0-react";
import { Box } from "@mui/material";
import React from "react";
import { Constants } from "../../../constants";
import { StyledMoleculeBox } from "../../../helper/styledComponents";
import Button from "../../atoms/button";
import Icon from "../../atoms/icon";
import HeaderText from "../../molecules/headerText";

const Header: React.FC = () => {
  const { user, loginWithRedirect, isAuthenticated, logout } = useAuth0();
  return (
    <StyledMoleculeBox>
      <HeaderText
        mainText={Constants.TITLE}
        mainVariant="h1"
        secondaryText={Constants.DESCRIPTION}
        secondaryVariant="subtitle1"
      />
      <Box sx={{ marginRight: "40px" }}>
        {isAuthenticated ? (
          <Icon
            src={user?.picture}
            alt={user?.name}
            height="32px"
            width="32px"
            onClick={logout}
            tooltip={user?.name}
            style={{ borderRadius: "12px", cursor: "pointer" }}
          />
        ) : (
          <Button variant="outlined" onClick={() => loginWithRedirect()}>
            Login
          </Button>
        )}
      </Box>
    </StyledMoleculeBox>
  );
};

export default Header;
