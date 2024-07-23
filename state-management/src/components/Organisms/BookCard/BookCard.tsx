import { Box, Card, CardContent, CardMedia } from "@mui/material";
import React from "react";
import BookDetails from "../../Molecules/BookDetails/BookDetails";
import Button from "../../Atoms/Button/Button";
interface BookCardProps {
  title: string;
  author: string;
  readTime: string;
  image: string;
  status: "Finished" | "Currently Reading";
  onChangeStatus: () => void;
}
const BookCard: React.FC<BookCardProps> = ({
  title,
  author,
  readTime,
  image,
  status,
  onChangeStatus,
}) => {
  return (
    <Card>
      <CardMedia component="img" src={image} alt={title} />
      <CardContent>
        <BookDetails title={title} author={author} readTime={readTime} />
        <Box sx={{ display: "flex", justifyContent: "center" }}>
          <Button onClick={onChangeStatus} variant="text">
            {status === "Finished" ? "Read again" : "Finished"}
          </Button>
        </Box>
      </CardContent>
    </Card>
  );
};

export default BookCard;
