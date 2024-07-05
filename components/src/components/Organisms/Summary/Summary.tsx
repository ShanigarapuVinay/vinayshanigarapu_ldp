import React from "react";
import SummaryData, { SummaryDataProps } from "../../Molecules/SummaryData/SummaryData";
import Typography from "../../Atoms/Typography/Typography";
import Button from "../../Atoms/Button/Button";
import './summary.css';

interface SummaryProps {
  summaryInfo: SummaryDataProps[];
}
const Summary: React.FC<SummaryProps> = ({ summaryInfo }) => {
  return (
    <div className="summary">
      <Typography text="Summary" className="main" />
      {summaryInfo.map((item) => (
        <SummaryData
          mainText={item.mainText}
          subText={item.subText}
          key={item.mainText}
        />
      ))}
      <hr />
      <SummaryData mainText="Total Payout" subText="$150,000.00" mainTextClassName="heading2" subTextClassName="main"/>
      <Button label="Submit your credit" />
    </div>
  );
};

export default Summary;
