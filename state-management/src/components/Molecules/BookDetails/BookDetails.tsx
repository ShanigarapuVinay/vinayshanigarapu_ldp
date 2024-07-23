import React from 'react'
import Typography from '../../Atoms/Typography/Typography';

interface BookDetailsProps{
    title: string;
    author: string;
    readTime: string;
}
const BookDetails: React.FC<BookDetailsProps> = ({title, author, readTime}) => {
  return (
    <div>
        <Typography variant='h5'>{title}</Typography>
        <Typography variant='subtitle1'>{author}</Typography>
        <Typography variant='body2'>{readTime}</Typography>
    </div>
  )
}

export default BookDetails