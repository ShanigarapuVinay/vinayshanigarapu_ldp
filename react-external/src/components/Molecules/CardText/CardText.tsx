import { Stack, Typography } from "@mui/material";
import React from "react";
import Icon from "../../Atoms/Icon/Icon";

const CardText: React.FC = () => {
  return (
    <Stack direction="row" spacing={26}>
      <div className="text">
        <Typography variant="h1">User Experience Designer</Typography>
        <Typography variant="body1">Myntra</Typography>
        <Typography variant="body2">Hitech city, Hyderabad - 500072</Typography>
      </div>
      <div className="more">
        <Icon
          src={`${process.env.PUBLIC_URL}/asserts/more.svg`}
          height="24"
          alt="More"
        />
      </div>
    </Stack>
  );
};

export default CardText;
