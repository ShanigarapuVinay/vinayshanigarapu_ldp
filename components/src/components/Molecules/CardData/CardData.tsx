import React from "react";
import Icons from "../../Atoms/Icons/Icons";
import Typography from "../../Atoms/Typography/Typography";
import "./cardData.css";

export interface CardDataProps {
  mainText: string;
  subText: string;
  children: React.ReactNode;
}
const CardData: React.FC<CardDataProps> = ({ mainText, subText, children }) => {
  return (
    <div className="card-data">
      <div className="card-icon">
        <Icons>{children}</Icons>
      </div>
      <Typography text={subText} className="sub" />
      <Typography text={mainText} className="main" />
    </div>
  );
};

export default CardData;
