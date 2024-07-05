import React from "react";
import './typography.css';

interface TypographyProps {
  text: string;
  className?: string;
}
const Typography: React.FC<TypographyProps> = ({ text, className }) => {
  return <p className={className}>{text}</p>;
};

export default Typography;
