import React from 'react'

interface IconProps{
    src: string;
    height: string;
    alt: string;
}
const Icon: React.FC<IconProps> = ({src, height, alt}) =>  {
  return <img src={src} alt={alt} height={height}/>
}

export default Icon