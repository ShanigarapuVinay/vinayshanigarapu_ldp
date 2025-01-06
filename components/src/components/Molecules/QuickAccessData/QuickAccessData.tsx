import React from "react";
import Typography from "../../Atoms/Typography/Typography";

export interface QuickAccessDataProps {
  mainText: string;
  subText: string;
}
const QuickAccessData: React.FC<QuickAccessDataProps> = ({ mainText, subText }) => {
  return (
    <div className="quick-access-data">
      <Typography text={mainText} className='main'/>
      <Typography text={subText} className='sub'/>
    </div>
  );
};

export default QuickAccessData;
