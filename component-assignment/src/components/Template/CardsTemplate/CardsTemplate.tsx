import { Container, ThemeProvider } from "@mui/material";
import React from "react";
import Data from "../../Molecules/Header/Data";
import Cards from "../../Organisms/Cards/Cards";
import theme from "../../../Helper/Theme/Theme";

const CardsTemplate: React.FC = () => {
  return (
    <ThemeProvider theme={theme}>
      <Container sx={{m: 4}}>
        <Data
          mainText="Get your site up and running"
          mainTextVariant="h3"
          subText="Get started with a video course on Webflow University and start building your website today."
          subTextVariant="body1"
        />
        <Cards />
      </Container>
    </ThemeProvider>
  );
};

export default CardsTemplate;
