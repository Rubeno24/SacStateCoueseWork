'use strict';

const express = require('express');
const app = express();

//endpoint 1
app.get("/math/circle/:r", function(req, res) {
  let radius = Number(req.params["r"]);
  let area = (Math.PI * radius * radius).toFixed(2);
  let circumference = (Math.PI * radius * 2).toFixed(2);
  res.type('text')
  res.send({"area": area, "circumference": circumference});
});

// endpoint 2
app.get('/hello/name', (req, res) => {
  if(req.query.first == undefined || req.query.last == undefined)
      res.status(400).send('Missing Required GET parameters: first, last');
  else
      res.send('Hello '+req.query.first + ' '+req.query.last)
})

const PORT = process.env.PORT || 8000;
app.listen(PORT);