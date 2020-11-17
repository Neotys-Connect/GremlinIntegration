package io.swagger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gremlin.api.JSON;
import com.gremlin.api.model.ScenarioResponse;
import org.junit.Test;

import java.util.List;

public class ScenarioResponseTest {

    //[
    //  {
    //    "org_id": "4de1c011-706b-59e4-a65b-54b4d401cbf6",
    //    "guid": "b4b41f9c-c6b5-42ee-b41f-9cc6b5e2ee0d",
    //    "name": "test",
    //    "description": "test",
    //    "hypothesis": "test",
    //    "graph": {
    //      "nodes": {
    //        "0": {
    //          "target_definition": {
    //            "strategy_type": "Exact",
    //            "target_type": "Host",
    //            "strategy": {
    //              "all_hosts": true,
    //              "attrs": {},
    //              "type": "Exact"
    //            }
    //          },
    //          "impact_definition": {
    //            "infra_command_type": "blackhole",
    //            "infra_command_args": {
    //              "hostnames": "^api.gremlin.com",
    //              "egress_ports": "^53",
    //              "providers": [],
    //              "type": "blackhole",
    //              "length": 60,
    //              "cli_args": [
    //                "blackhole",
    //                "-l",
    //                "60",
    //                "-h",
    //                "^api.gremlin.com",
    //                "-p",
    //                "^53"
    //              ]
    //            }
    //          },
    //          "type": "InfraAttack",
    //          "id": "0",
    //          "next": "1",
    //          "state": {
    //            "lifecycle": "NotStarted"
    //          },
    //          "guid": "250b2be4-244e-4189-8b2b-e4244e818915"
    //        },
    //        "1": {
    //          "delay": 5,
    //          "type": "Delay",
    //          "id": "1",
    //          "next": "2",
    //          "state": {
    //            "lifecycle": "NotStarted"
    //          },
    //          "guid": "6b7d3483-c7b4-416d-bd34-83c7b4916dd3"
    //        },
    //        "2": {
    //          "target_definition": {
    //            "strategy_type": "Exact",
    //            "target_type": "Host",
    //            "strategy": {
    //              "all_hosts": true,
    //              "attrs": {},
    //              "type": "Exact"
    //            }
    //          },
    //          "impact_definition": {
    //            "infra_command_type": "cpu",
    //            "infra_command_args": {
    //              "cores": 1,
    //              "percent": 100,
    //              "all_cores": false,
    //              "type": "cpu",
    //              "length": 60,
    //              "cli_args": [
    //                "cpu",
    //                "-l",
    //                "60",
    //                "-c",
    //                "1"
    //              ]
    //            }
    //          },
    //          "type": "InfraAttack",
    //          "id": "2",
    //          "state": {
    //            "lifecycle": "NotStarted"
    //          },
    //          "guid": "3e02e4c4-51bc-4966-82e4-c451bc5966f6"
    //        }
    //      },
    //      "start_id": "0"
    //    },
    //    "state": "PUBLISHED",
    //    "create_source": "WebApp",
    //    "created_by": "henrik.rexed@neotys.com",
    //    "created_at": "2020-09-24T13:27:07.508Z",
    //    "updated_at": "2020-11-05T16:18:07.490Z",
    //    "last_run_at": "2020-11-05T16:18:07.378Z",
    //    "tiers": [
    //      "Free",
    //      "Enterprise"
    //    ]
    //  }
    //]

    String response ="  {\n" +
            "    \"org_id\": \"4de1c011-706b-59e4-a65b-54b4d401cbf6\",\n" +
            "    \"guid\": \"b4b41f9c-c6b5-42ee-b41f-9cc6b5e2ee0d\",\n" +
            "    \"name\": \"test\",\n" +
            "    \"description\": \"test\",\n" +
            "    \"hypothesis\": \"test\",\n" +
            "    \"graph\": {\n" +
            "      \"nodes\": {\n" +
            "        \"0\": {\n" +
            "          \"target_definition\": {\n" +
            "            \"strategy_type\": \"Exact\",\n" +
            "            \"target_type\": \"Host\",\n" +
            "            \"strategy\": {\n" +
            "              \"all_hosts\": true,\n" +
            "              \"attrs\": {},\n" +
            "              \"type\": \"Exact\"\n" +
            "            }\n" +
            "          },\n" +
            "          \"impact_definition\": {\n" +
            "            \"infra_command_type\": \"blackhole\",\n" +
            "            \"infra_command_args\": {\n" +
            "              \"hostnames\": \"^api.gremlin.com\",\n" +
            "              \"egress_ports\": \"^53\",\n" +
            "              \"providers\": [],\n" +
            "              \"type\": \"blackhole\",\n" +
            "              \"length\": 60,\n" +
            "              \"cli_args\": [\n" +
            "                \"blackhole\",\n" +
            "                \"-l\",\n" +
            "                \"60\",\n" +
            "                \"-h\",\n" +
            "                \"^api.gremlin.com\",\n" +
            "                \"-p\",\n" +
            "                \"^53\"\n" +
            "              ]\n" +
            "            }\n" +
            "          },\n" +
            "          \"type\": \"InfraAttack\",\n" +
            "          \"id\": \"0\",\n" +
            "          \"next\": \"1\",\n" +
            "          \"state\": {\n" +
            "            \"lifecycle\": \"NotStarted\"\n" +
            "          },\n" +
            "          \"guid\": \"250b2be4-244e-4189-8b2b-e4244e818915\"\n" +
            "        },\n" +
            "        \"1\": {\n" +
            "          \"delay\": 5,\n" +
            "          \"type\": \"Delay\",\n" +
            "          \"id\": \"1\",\n" +
            "          \"next\": \"2\",\n" +
            "          \"state\": {\n" +
            "            \"lifecycle\": \"NotStarted\"\n" +
            "          },\n" +
            "          \"guid\": \"6b7d3483-c7b4-416d-bd34-83c7b4916dd3\"\n" +
            "        },\n" +
            "        \"2\": {\n" +
            "          \"target_definition\": {\n" +
            "            \"strategy_type\": \"Exact\",\n" +
            "            \"target_type\": \"Host\",\n" +
            "            \"strategy\": {\n" +
            "              \"all_hosts\": true,\n" +
            "              \"attrs\": {},\n" +
            "              \"type\": \"Exact\"\n" +
            "            }\n" +
            "          },\n" +
            "          \"impact_definition\": {\n" +
            "            \"infra_command_type\": \"cpu\",\n" +
            "            \"infra_command_args\": {\n" +
            "              \"cores\": 1,\n" +
            "              \"percent\": 100,\n" +
            "              \"all_cores\": false,\n" +
            "              \"type\": \"cpu\",\n" +
            "              \"length\": 60,\n" +
            "              \"cli_args\": [\n" +
            "                \"cpu\",\n" +
            "                \"-l\",\n" +
            "                \"60\",\n" +
            "                \"-c\",\n" +
            "                \"1\"\n" +
            "              ]\n" +
            "            }\n" +
            "          },\n" +
            "          \"type\": \"InfraAttack\",\n" +
            "          \"id\": \"2\",\n" +
            "          \"state\": {\n" +
            "            \"lifecycle\": \"NotStarted\"\n" +
            "          },\n" +
            "          \"guid\": \"3e02e4c4-51bc-4966-82e4-c451bc5966f6\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"start_id\": \"0\"\n" +
            "    },\n" +
            "    \"state\": \"PUBLISHED\",\n" +
            "    \"create_source\": \"WebApp\",\n" +
            "    \"created_by\": \"henrik.rexed@neotys.com\",\n" +
            "    \"created_at\": \"2020-09-24T13:27:07.508Z\",\n" +
            "    \"updated_at\": \"2020-11-05T16:18:07.490Z\",\n" +
            "    \"last_run_at\": \"2020-11-05T16:18:07.378Z\",\n" +
            "    \"tiers\": [\n" +
            "      \"Free\",\n" +
            "      \"Enterprise\"\n" +
            "    ]\n" +
            "  }";

    @Test
    public void serializeTest()
    {
        Gson gson=JSON.createGson().create();
        ScenarioResponse responses=gson.fromJson(response,ScenarioResponse.class);

        System.out.println(responses.getGuid());
    }
}
