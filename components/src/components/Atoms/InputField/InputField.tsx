import React from "react";
import './inputField.css';

interface InputFieldProps {
  type: string;
  placeholder: string;
  required: boolean;
}
const InputField: React.FC<InputFieldProps> = ({ type, placeholder, required }) => {
  return (
      <input type={type} placeholder={placeholder} className="input-field" required={required}/>
  );
};

export default InputField;
