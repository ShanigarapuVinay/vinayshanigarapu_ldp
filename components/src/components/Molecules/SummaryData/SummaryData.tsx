import React from "react";
import Typography from "../../Atoms/Typography/Typography";
import './summaryData.css'


export interface SummaryDataProps {
  mainText: string;
  subText: string;
  mainTextClassName?: string;
  subTextClassName?: string;
}
const SummaryData: React.FC<SummaryDataProps> = ({
  mainText,
  subText,
  mainTextClassName="sub",
  subTextClassName="sub2"
}) => {
  return (
    <div className="summary-data">
        <Typography text={mainText} className={mainTextClassName}/>
        <Typography text={subText} className={subTextClassName} />
    </div>
  );
};

export default SummaryData;
