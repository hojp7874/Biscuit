// /* 모듈 불러오기 */
// const express = require('express');
// const https = require('https');
// const socket = require('socket.io');

// /* express 객체 생성 */
// const app = express();
// const PORT = 9988; // PORT 번호
// /* express http 서버 생성 및 socket.io 에 바인딩 */
// const server = https.createServer(app);
// const io = socket(server);
// /* 서버의 홈('/')에 접속시 메시지 전송 */
// app.get('/', function (req, res) {
//   res.send('Hello...?');
// });
// /* 서버가 실행되면 출력 */
// server.listen(PORT, function () {
//   console.log('Server is running');
// });

// var socketIO = require('socket.io');

// const https = require('https');
// const fs = require('fs');
// const options = {
//   key: fs.readFileSync('./private.pem'),
//   cert: fs.readFileSync('./public.pem'),
// };
// var fileServer = new nodeStatic.Server();
// let app = https
//   .createServer(options, (req, res) => {
//     fileServer.serve(req, res);
//   })
//   .listen(9988);

// console.log('Started chating server...');

/* 모듈 불러오기 */
const express = require('express');
const https = require('https');

const socket = require('socket.io');
const fs = require('fs');
const options = {
  key: fs.readFileSync('./private.pem'),
  cert: fs.readFileSync('./public.pem'),
};

/* express 객체 생성 */
const app = express();
const PORT = 9988; // PORT 번호
/* express http 서버 생성 및 socket.io 에 바인딩 */
const server = https
  .createServer(options, (req, res) => {
    fileServer.serve(req, res);
  })
  .listen(8877);

const io = socket(server);
/* 서버의 홈('/')에 접속시 메시지 전송 */
app.get('/', function (req, res) {
  res.send('Hello...?');
});
/* 서버가 실행되면 출력 */
server.listen(PORT, function () {
  console.log('Server is running');
});
