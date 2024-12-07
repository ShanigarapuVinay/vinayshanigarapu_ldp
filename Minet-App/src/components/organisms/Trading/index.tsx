import { Box, IconButton } from "@mui/material";
import React, { useState } from "react";
import { theme } from "../../../theme";
import { DATA, HEADERS, IconPath } from "../../../utils/Constants";
import Icon from "../../atoms/Icon";
import Tabs from "../../atoms/Tabs";
import Typography from "../../atoms/Typography";
import AssertCard from "../../molecules/AssertCard";
import Iconography from "../../molecules/Iconography";
import { Header, Row, StyledBody, StyledRow, Wrapper } from "./index.styles";

const Trading: React.FC = () => {
  const [tab, setTab] = useState(0);
  const [items, setItems] = useState<Set<number>>(new Set());

  const handleTabChange = (_event: React.SyntheticEvent, newValue: number) => {
    setTab(newValue);
  };

  const handleWatchToggle = (itemId: number) => {
    setItems((prev) => {
      const newSet = new Set(prev);
      if (newSet.has(itemId)) {
        newSet.delete(itemId);
      } else {
        newSet.add(itemId);
      }
      return newSet;
    });
  };

  const filteredData =
    tab === 0 ? DATA : DATA.filter((item) => items.has(item.id));

  return (
    <Wrapper>
      <Tabs value={tab} onChange={handleTabChange} />
      <Box>
        <Header>
          {HEADERS.map((item) => (
            <StyledRow key={item.id} width={item.width} height={item.height}>
              {item.icon ? (
                <Iconography
                  src={item.icon}
                  variant={item.variant}
                  color={theme.palette.secondary.dark}
                  key={item.id}
                >
                  {item.text}
                </Iconography>
              ) : (
                <Typography
                  variant={item.variant}
                  color={theme.palette.secondary.dark}
                  key={item.id}
                >
                  {item.text}
                </Typography>
              )}
            </StyledRow>
          ))}
        </Header>

        <StyledBody>
          {filteredData.map((item) => (
            <Row key={item.id}>
              <StyledRow width={HEADERS[0].width} height={HEADERS[0].height}>
                <AssertCard
                  src={item.image}
                  mainText={item.mainText}
                  mainVariant={item.mainVarinat}
                  mainColor={item.mainColor}
                  subColor={item.subColor}
                  subText={item.subText}
                  subVariant={item.subVarinat}
                  key={item.id}
                />
              </StyledRow>

              <StyledRow width={HEADERS[1].width} height={HEADERS[1].height}>
                <Typography variant="body2" color={theme.palette.primary.dark}>
                  {item.price}
                </Typography>
              </StyledRow>

              <StyledRow width={HEADERS[2].width} height={HEADERS[2].height}>
                <Typography
                  variant="body2"
                  color={
                    item.change.startsWith("+")
                      ? theme.palette.primary.main
                      : theme.palette.secondary.main
                  }
                >
                  {item.change}
                </Typography>
              </StyledRow>

              <StyledRow width={HEADERS[3].width} height={HEADERS[3].height}>
                <Typography variant="body2" color={theme.palette.primary.dark}>
                  {item.market}
                </Typography>
              </StyledRow>

              <StyledRow width={HEADERS[4].width} height={HEADERS[4].height}>
                <IconButton onClick={() => handleWatchToggle(item.id)}>
                  {items.has(item.id) ? (
                    <Icon src={IconPath.star1} />
                  ) : (
                    <Icon src={IconPath.star2} />
                  )}
                </IconButton>
              </StyledRow>
            </Row>
          ))}
        </StyledBody>
      </Box>
    </Wrapper>
  );
};

export default Trading;
