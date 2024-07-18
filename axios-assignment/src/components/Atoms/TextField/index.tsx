import { TextFieldProps, TextField as MuiTextField } from '@mui/material'
import React from 'react'

const TextField: React.FC<TextFieldProps> = ({type, value, label, variant, onChange}) => {
  return <MuiTextField type={type} value={value} label={label} variant={variant} onChange={onChange} />
}

export default TextField