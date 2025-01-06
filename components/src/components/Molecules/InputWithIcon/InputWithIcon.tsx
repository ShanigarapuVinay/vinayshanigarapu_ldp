import React from "react";
import Icons from "../../Atoms/Icons/Icons";
import InputField from "../../Atoms/InputField/InputField";
import "./inputWithIcon.css";


interface InputWithIconProps {
  type: string;
  placeholder: string;
  src: string;
  alt: string;
  height: string;
  required: boolean;
}
const InputWithIcon: React.FC<InputWithIconProps> = ({
  type,
  placeholder,
  src,
  alt,
  height,
  required,
}) => {
  return (
    <div className="input-with-icon">
      <Icons src={src} alt={alt} height={height} />
      <InputField type={type} placeholder={placeholder} required={required} />
    </div>
  );
};

export default InputWithIcon;
