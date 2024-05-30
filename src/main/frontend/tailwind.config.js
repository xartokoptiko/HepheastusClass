/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["../resources/templates/**/*.{html,js}"], // it will be explained later
  theme: {
    extend: {
        colors :{
                "white" : "#FFFFFF",
                "black"  : "#000000",
                "lightgray" : "#EEEEEE",
                "blue" : "#173253",
                "red" : "#ff0e36",
                "customPurple": '#9200AA',
                "customGray": '#2D2D2D',
                "lightPurple": "#B155CC"
              },
              backgroundImage: {
                      'custom-gradient': 'linear-gradient(135deg, #9200AA 0%, #2D2D2D 70%)',
                      'hover-gradient': 'linear-gradient(135deg, #9200AA 0%, #B155CC 70%)',
                      'hover-gradient-reverse': 'linear-gradient(135deg, #B155CC 0%, #9200AA 70%)',
                    },
    },
  },
  plugins: [],
}