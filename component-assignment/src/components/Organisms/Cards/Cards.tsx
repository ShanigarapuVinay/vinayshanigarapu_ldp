import { Box, Container, Grid } from "@mui/material";
import React from "react";
import { data } from "../../../Constants/Data/data";
import Card from "../../Molecules/Card/Card";

const Cards: React.FC = () => {
  return (
    <Container disableGutters sx={{ overflow: "hidden" }}>
      <Grid container spacing={1.5}>
        {data.map((item) => (
          <Grid item xs={12} sm={10} md={6} key={item.title}>
            <Box>
              <Card
                src={item.image}
                alt={item.title}
                height="110"
                mainText={item.title}
                mainTextVariant="h4"
                subText={item.description}
                subTextVariant="subtitle1"
              />
            </Box>
          </Grid>
        ))}
      </Grid>
    </Container>
  );
};

export default Cards;
