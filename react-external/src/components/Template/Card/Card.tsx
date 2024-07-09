import { Paper, Stack, ThemeProvider } from "@mui/material";
import React from "react";
import CardData from "../../Organism/CardData/CardData";
import Icon from "../../Atoms/Icon/Icon";
import theme from "../../../Helper/Theme";

const Card: React.FC = () => {
  return (
    <ThemeProvider theme={theme}>
      <Paper>
        <Stack direction="row" spacing={3}>
          <div className="logo">
            <Icon
              src={`${process.env.PUBLIC_URL}/asserts/Logo.svg`}
              height="45"
              alt="More"
            />
          </div>
          <CardData />
        </Stack>
      </Paper>
    </ThemeProvider>
  );
};

export default Card;
