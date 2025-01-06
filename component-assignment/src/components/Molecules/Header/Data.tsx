import { Container, Stack } from "@mui/material";
import React from "react";
import Typography from "../../Atoms/Typography/Typography";
import { TypographyProps } from "../../../Shared/Typography/TypographyProps";
interface DataProps extends TypographyProps{};
const Data: React.FC<DataProps> = ({ mainText, subText, mainTextVariant, subTextVariant }) => {
  return (
    <Container>
      <Stack>
        <Typography variant={mainTextVariant} label={mainText} />
        <Typography variant={subTextVariant} label={subText} />
      </Stack>
    </Container>
  );
};

export default Data;
