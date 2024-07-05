import React from "react";

interface IconsProps {
  children: React.ReactNode;
}

const Icons: React.FC<IconsProps> = ({ children }) => (
  <div className="icon">{children}</div>
);

export default Icons;
