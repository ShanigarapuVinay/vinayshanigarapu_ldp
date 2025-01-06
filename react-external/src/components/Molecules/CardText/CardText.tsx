import { Stack, Typography } from "@mui/material";
import React from "react";
import Icon from "../../Atoms/Icon/Icon";
import { ICONS } from "../../../Constants/Icons";
import { TEXT } from "../../../Constants/texts";

const CardText: React.FC = () => {
  return (
    <Stack direction="row" spacing={26}>
      <div className="text">
        <Typography variant="h1">{TEXT.TITLE}</Typography>
        <Typography variant="body1">{TEXT.COMPANY}</Typography>
        <Typography variant="body2">{TEXT.LOCATION}</Typography>
      </div>
      <div className="more">
        <Icon src={ICONS.MORE} height="24" alt="More" />
      </div>
    </Stack>
  );
};

export default CardText;
