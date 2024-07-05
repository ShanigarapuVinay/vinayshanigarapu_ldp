import React from "react";
import Icons from "../../Atoms/Icons/Icons";
import InputField from "../../Atoms/InputField/InputField";
import "./inputWithIcon.css";


interface InputWithIconProps {
  type: string;
  placeholder: string;
  children: React.ReactNode;
  required: boolean;
}
const InputWithIcon: React.FC<InputWithIconProps> = ({
  type,
  placeholder,
  children,
  required,
}) => {
  return (
    <div className="input-with-icon">
      <Icons>{children}</Icons>
      <InputField type={type} placeholder={placeholder} required={required} />
    </div>
  );
};

export default InputWithIcon;
