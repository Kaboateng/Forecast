FROM node:alpine

WORKDIR /forecast/src/app

COPY . /forecast/src/app/

RUN npm install -g @angular/cli

RUN npm install

CMD ["ng", "serve", "--host", "0.0.0.0"]