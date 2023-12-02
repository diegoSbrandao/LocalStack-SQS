#!/bin/bash

aws --endpoint-url http://localhost:9324 sqs create-queue --queue-name compra_cartao_credito
