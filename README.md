# Install Kafka

`brew install kafka`

# Start Kafka services

`brew services start zookeeper`

`brew services start kafka`

# Send message

`curl -d 'message1234' -H "Content-Type: plain/text" -X POST http://localhost:8081/message`

# Get all messages

`curl http://localhost:8081/messages`