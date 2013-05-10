var app, eco, express, port;

require("coffee-script");

express = require('express');

eco = require('eco');

/*
creating server
*/


app = express.createServer();

/*
server configuration
*/


app.configure(function() {
  app.set('views', __dirname + "/views");
  app.set('view engine', 'eco');
  app.use(express.bodyParser());
  return app.use(express["static"](__dirname));
});

/*
routing and view rendering
*/


app.get('/', function(req, res) {
  return res.render('login', {
    title: 'log in'
  });
});

/*
handling post requests
*/


app.post('/fpmi/login', function(req, res) {
  /*
  	user object which is sent from login form
  */

  var user;

  user = req.body.user;
  /*
  	Usually you will check the login data accessing a database or similiar
  	For the sake of this demo it just uses hardcoded values here
  */

  if (user.name === 'luke' && user.password === 'skywalker') {
    return res.render('loggedin', {
      title: "Logged in as " + user.name,
      user: user
    });
  } else {
    return res.render('login', {
      title: 'Error',
      error: true
    });
  }
});

app.post('/fpmi', function(req, res) {
  return res.render('login', {
    title: 'logged out',
    loggedOut: true
  });
});

/*
run server
*/


port = process.env.PORT || 9294;

app.listen(port, function() {
  return console.log("Server is starting on port: " + port);
});