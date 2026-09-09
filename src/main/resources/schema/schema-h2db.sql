CREATE TABLE IF NOT EXISTS SPRING_AI_CHAT_MEMORY (
                                                     conversation_id VARCHAR(36) NOT NULL,
                                                     content LONGVARCHAR NOT NULL,
                                                     type VARCHAR(10) NOT NULL,
                                                     "TIMESTAMP" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                                                     sequence_id BIGINT NOT NULL,
                                                     CONSTRAINT SPRING_AI_CHAT_MEMORY_TYPE_CHECK CHECK (type IN ('USER', 'ASSISTANT', 'SYSTEM', 'TOOL')),
                                                     CONSTRAINT SPRING_AI_CHAT_MEMORY_PK PRIMARY KEY (conversation_id, sequence_id)
);

CREATE INDEX IF NOT EXISTS SPRING_AI_CHAT_MEMORY_CONVERSATION_ID_TIMESTAMP_IDX
    ON SPRING_AI_CHAT_MEMORY(conversation_id, "TIMESTAMP" DESC);