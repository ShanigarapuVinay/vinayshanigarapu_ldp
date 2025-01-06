import React from "react";
import Button from "../../Atoms/Button/Button";
import QuickAccessData from "../../Molecules/QuickAccessData/QuickAccessData";
import "./quickAccessCard.css";

const QuickAccessCard: React.FC = () => {
  return (
    <div className="quick-access-card">
      <QuickAccessData mainText="Launch a new Cask Kick" subText="You have upto $880,000.00 available for a new cash advance" />
      <Button label="New Cash Kick" />
    </div>
  );
};

export default QuickAccessCard;
