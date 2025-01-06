import ButterChicken from "./Asserts/Images/ButterChicken.jpeg";
import PannerTikka from "./Asserts/Images/PannerTikka.jpeg";
import MasalaDosa from "./Asserts/Images/MasalaDosa.jpeg";
import PalakPanner from "./Asserts/Images/PalakPaneer.jpeg";
import CholeBhature from "./Asserts/Images/CholeBhature.jpeg";
import GulabJamun from "./Asserts/Images/GulabJamun.jpeg";
const items = [
  {
    id: "1",
    image: ButterChicken,
    title: "Butter Chicken",
    recipe: `
      Heat butter in a pan and sauté onions until golden brown, add garlic and ginger paste and cook for a minute. 
      Add chicken pieces and cook until they turn white, add turmeric powder, chili powder, and garam masala. 
      Add tomato puree and cook for 10 minutes, add heavy cream and cook until the sauce thickens. 
      Garnish with fresh coriander and serve hot with naan or rice.
      `,
  },
  {
    id: "2",
    image: PannerTikka,
    title: "Paneer Tikka",
    recipe: `
      In a bowl, mix yogurt, ginger-garlic paste, turmeric powder, chili powder, garam masala, chaat masala, lemon juice, and salt, add paneer cubes and marinate for at least 1 hour.
      Thread the marinated paneer onto skewers. Grill the skewers until the paneer is golden brown on all sides. Serve hot with mint chutney and lemon wedges.
      `,
  },
  {
    id: "3",
    image: MasalaDosa,
    title: "Masala Dosa",
    recipe: `
      Soak rice and urad dal separately for 4-6 hours. Grind to a smooth batter and ferment overnight, heat oil in a pan, add mustard seeds, and let them splutter. Add onions, green chilies, and ginger paste. Cook until onions are translucent.
      Add turmeric powder, mashed potatoes, salt, and fresh coriander. Mix well, heat a non-stick pan, pour a ladle of dosa batter, and spread it thin.
      Add a spoonful of potato filling in the center and fold the dosa. Serve hot with coconut chutney and sambar.
      `,
  },
  {
    id: "4",
    image: PalakPanner,
    title: "Palak Paneer",
    recipe: `
      Blanch spinach leaves in boiling water for 2 minutes. Drain and blend to a smooth puree, heat oil in a pan, add cumin seeds, and let them splutter. Add onions and sauté until golden brown.
      Add ginger-garlic paste and cook for a minute. Add tomato puree and cook until the oil separates, add turmeric powder, garam masala, and salt. Mix well.
      Add spinach puree and cook for 5 minutes. Add paneer cubes and mix gently, stir in the cream and cook for another 2 minutes. Serve hot with naan or rice.
      `,
  },
  {
    id: "5",
    image: CholeBhature,
    title: "Chole Bhature",
    recipe: `
      For chole, pressure cook soaked chickpeas with salt until tender. Drain and set aside, heat oil in a pan, add cumin seeds, and let them splutter. Add onions and sauté until golden brown.
      Add ginger-garlic paste and cook for a minute. Add tomatoes and cook until soft, add turmeric powder, chole masala, garam masala, and salt. Mix well.
      Add cooked chickpeas and some water. Simmer for 10 minutes. Garnish with fresh coriander, for bhature, mix flour, baking powder, sugar, salt, and yogurt. Knead into a soft dough. Let it rest for 2 hours.
      Divide the dough into small balls and roll them into discs. Deep fry in hot oil until golden brown.
      Serve hot chole with bhature.
      `,
  },
  {
    id: "6",
    image: GulabJamun,
    title: "Gulab Jamun",
    recipe: `
      For the sugar syrup, mix sugar and water in a pan. Bring to a boil and simmer for 10 minutes. Add cardamom powder, saffron strands, and rose water. Keep aside, in a bowl, mix milk powder, flour, baking soda, and ghee. Add milk little by little to make a soft dough.
      Divide the dough into small balls ensuring there are no cracks, heat oil in a pan and fry the balls on low heat until golden brown.
      Soak the fried balls in warm sugar syrup for at least 2 hours. Serve warm or at room temperature.
      `,
  },
];

export default items;
