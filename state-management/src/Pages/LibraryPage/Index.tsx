import React, { useState } from "react";
import Library from "../../components/Template/LibraryTemplate/Library";
import BookCard from "../../components/Organisms/BookCard/BookCard";
import { BooksData } from "../../Constants/BooksData";
import { ThemeProvider } from "@emotion/react";
import theme from "../../Helper/Theme";
import { CssBaseline } from "@mui/material";

const Index: React.FC = () => {
  const [tabIndex, setTabIndex] = useState(0);
  const [books, setBooks] = useState(BooksData);

  const handleChangeStatus = (id: number) => {
    setBooks((prevBooks) =>
      prevBooks.map((book) =>
        book.ID === id
          ? {
              ...book,
              STATUS:
                book.STATUS === "Finished" ? "Currently Reading" : "Finished",
            }
          : book
      )
    );
  };

  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Library tabIndex={tabIndex} setTabIndex={setTabIndex}>
        {books
          .filter((book) =>
            tabIndex === 0
              ? book.STATUS === "Currently Reading"
              : book.STATUS === "Finished"
          )
          .map((book) => (
            <BookCard
              key={book.ID}
              title={book.TITLE}
              author={book.AUTHOR}
              image={book.IMAGE}
              readTime={book.READTIME}
              status={book.STATUS as "Finished" | "Currently Reading"}
              onChangeStatus={() => handleChangeStatus(book.ID)}
            />
          ))}
      </Library>
    </ThemeProvider>
  );
};

export default Index;
