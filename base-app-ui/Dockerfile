#############################################################################################
###                                  Build Application                                   ###
#############################################################################################
FROM node:12.7-alpine AS build
WORKDIR /usr/src/app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

#############################################################################################
###                                     Run Application                                   ###
#############################################################################################
FROM nginx:1.19.1-alpine
COPY --from=build /usr/src/app/dist/base-app-ui /usr/share/nginx/html