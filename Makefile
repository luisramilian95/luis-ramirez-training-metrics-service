#Usages
# make			# compile configure and run the app
# make clean 	# clean all the environment 


######################### DEFINITIONS ############################
config_file ?= config.env
include $(config_file)
export $(shell sed 's/=.*//' $(config_file))

# Define the environment variables by default if necessary:
ifeq ($(APP_NAME),)
    APP_NAME = metrics-app
endif

ifeq ($(APP_PORT),)
    APP_PORT = 8080
endif

ifeq ($(DB_PORT),)
 	DB_PORT = 5432
endif

ifeq ($(DB_HOST),)
	DB_HOST = localhost
endif

ifeq ($(DB_USERNAME),)
	DB_USERNAME = admin
endif

ifeq ($(DB_PASSWORD),)
	DB_PASSWORD = admin
endif

##################################################################

all : permission clean configure_environment compile run

.PHONY: all

permission: 
	chmod +x ./mvnw

clean: 
	@echo "cleaning"
	sh ./mvnw clean 
	rm -rf $(APP_NAME).jar configurations

clean_db:
	docker stop $(APP_NAME)-postgres >> /dev/null 2>&1 || true
	docker rm $(APP_NAME)-postgres >> /dev/null 2>&1 || true

build_db:
	docker stop $(APP_NAME)-postgres >> /dev/null 2>&1 || true
	docker rm $(APP_NAME)-postgres >> /dev/null 2>&1 || true
	docker run --name $(APP_NAME)-postgres -e POSTGRES_PASSWORD=$(DB_PASSWORD) -e POSTGRES_USER=$(DB_USERNAME) -e POSTGRES_DB=metrics -p$(DB_PORT):5432 -d postgres

configure_environment:
	@echo "configuring ..."
	@echo "Database host: $(DB_HOST)"
	@echo "Database port: $(DB_PORT)"
	@echo "Database username: $(DB_USERNAME)"
	@echo "Database password: $(DB_PASSWORD)"
	@echo "App port: $(APP_PORT)"
	@echo "App host: $(APP_HOST)"
	@echo "Building database metrics"
	mkdir configurations  
	cp application.properties configurations/application.properties
	echo "server.port=$(APP_PORT)" >>  configurations/application.properties
	echo "spring.datasource.url=jdbc:postgresql://$(DB_HOST):$(DB_PORT)/metrics" >> configurations/application.properties
	echo "spring.datasource.username=$(DB_USERNAME)" >> configurations/application.properties
	echo "spring.datasource.password=$(DB_PASSWORD)" >> configurations/application.properties
	echo "spring.flyway.user=$(DB_USERNAME)" >> configurations/application.properties
	echo "spring.flyway.password=$(DB_USERNAME)" >> configurations/application.properties
	echo "spring.flyway.url=jdbc:postgresql://$(DB_HOST):$(DB_PORT)/metrics" >> configurations/application.properties

compile:
	@echo "compiling ..."
	sh ./mvnw clean install 
	cp ./webapp/target/*-exec.jar $(APP_NAME).jar

run: 
	@echo "running ..."
	java -jar $(APP_NAME).jar --spring.config.location=configurations/application.properties

