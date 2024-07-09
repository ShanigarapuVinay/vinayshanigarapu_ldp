import { Paper, Stack, ThemeProvider } from "@mui/material";
import React from "react";
import CardData from "../../Organism/CardData/CardData";
import Icon from "../../Atoms/Icon/Icon";
import theme from "../../../Helper/Theme";
import { ICONS } from "../../../Constants/Icons";

const Card: React.FC = () => {
  return (
    <ThemeProvider theme={theme}>
      <Paper>
        <Stack direction="row" spacing={3}>
          <Icon src={ICONS.LOGO} height="45" alt="Logo" />
          <CardData />
        </Stack>
      </Paper>
    </ThemeProvider>
  );
};

export default Card;
