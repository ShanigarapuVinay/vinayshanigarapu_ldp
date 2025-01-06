import React from "react";

import { Stack } from "@mui/material";
import CardText from "../../Molecules/CardText/CardText";
import Icons from "../../Molecules/Icons/Icons";

const CardData: React.FC = () => {
  return (
    <Stack direction="column" spacing={3}>
      <CardText />
      <Icons />
    </Stack>
  );
};

export default CardData;
