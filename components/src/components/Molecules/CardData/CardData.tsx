import React from "react";
import Icons from "../../Atoms/Icons/Icons";
import Typography from "../../Atoms/Typography/Typography";
import "./cardData.css";

export interface CardDataProps {
  mainText: string;
  subText: string;
  src: string;
  alt: string;
  height: string;
}
const CardData: React.FC<CardDataProps> = ({
  mainText,
  subText,
  src,
  alt,
  height,
}) => {
  return (
    <div className="card-data">
      <div className="card-icon">
        <Icons src={src} alt={alt} height={height} />
      </div>
      <Typography text={subText} className="sub" />
      <Typography text={mainText} className="main" />
    </div>
  );
};

export default CardData;
