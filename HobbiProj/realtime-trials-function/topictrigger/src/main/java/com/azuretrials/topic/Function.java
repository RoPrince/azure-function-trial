package com.azuretrials.topic;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.annotation.ServiceBusTopicTrigger;

import java.util.Optional;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    @FunctionName("sbtopicprocessor")
    public void run(
            @ServiceBusTopicTrigger(
                    name = "message",
                    topicName = "tp-realtimenotif",
                    subscriptionName = "sub-realtime",
                    connection = "ServiceBusConnection"
            ) String message,
            final ExecutionContext context
    ) {
        context.getLogger().info(message);
    }
}
