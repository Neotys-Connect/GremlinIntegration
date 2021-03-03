# NeoLoad Gremlin Integration
<p align="center"><img src="/screenshot/icon.png" width="40%" alt="Gremlin" /></p>

This project is aimed to integrate NeoLoad with Gremlin, giving users the ability to trigger attacks during a NeoLoad test.
This project has 2 disctinct way of launching attacks :
* `Scenarios` : if you already have defined Scenarios within Gremlin . YOu will be able to trigger them directly in NeoLoad.
* `Attack` : you can create a flow of several attacks. NeoLoad will then run your flow during the test.
     
| Property | Value |
| -----| -------------- |
| Maturity | Experimental |
| Author   | Neotys Partner Team |
| License  | [BSD Simplified](https://www.neotys.com/documents/legal/bsd-neotys.txt) |
| NeoLoad  | 7.7 (Enterprise or Professional Edition w/ Integration & Advanced Usage and NeoLoad Web option required)|
| Requirements | NeoLoad Web |
| Bundled in NeoLoad | No
| Download Binaries | <ul><li>[latest release] is only compatible with NeoLoad from version 7.7</li></ul>|
                
### Installation

1. Download the [latest release]() for NeoLoad from version 7.7
1. Read the NeoLoad documentation to see [How to install a custom Advanced Action](https://www.neotys.com/documents/doc/neoload/latest/en/html/#25928.htm).

<p align="center"><img src="/screenshot/custom_action.png" alt="SupermonContext Advanced Action" /></p>

### Gremlin Custom Actions

#### Gremlin Scenario
##### Parameters for Runscenario
   
| Name             | Description |
| -----            | ----- |
| `Scenario`      | Name of your Gremlin Scenario |
| `GremlinToken`   |   Gremlin API token|
| `GremlinTeamID`   |  Gremlin Team ID |

#### Gremlin Attacks

Gremlin has several [Infrastructure attacks](https://www.gremlin.com/docs/infrastructure-layer/attacks/) :
* Ressource
* State
* Network

Every attack will have common parameters  :

| Name             | Description |
| -----            | ----- |
| `GremlinTargetType`      | Type of Target ( Host or container) |
| `GremlinToken`   |   Gremlin API token|
| `GremlinTeamID`   |  Gremlin Team ID |
| `GremlinTargetHostTags`      | This parameter will select the client that will run the attack with a the help of tags.List of tags seperated by a , |
| `GremlinToken`   |   Gremlin API token|
| `GremlinTarget`   |  Value possible exact or percent.  |
| `GremlinTargetNumber`   |  Number of client selected ( the number would be percentage or number depending on the value of GremlinTarget.  |


##### 1  Ressource Attacks
###### Specific Parameters for CPU
   
| Name             | Description |
| -----            | ----- |
| `Cores`    (optional)  | Number of cores impacted by the attack|
| `Length`  (optional)  |  Duration in second of the attack |
| `CPU Capacity`  (optional) |   Maximum cpu usage of the attack|

###### Specific Parameters for Memory
   
| Name             | Description |
| -----            | ----- |
| `Length` (optional)  |  Duration in second of the attack |
| `Cores`  (optional)    | Number of cores impacted by the attack|
| `MB`  (optional) |  The number of megabytes to allocate|
| `GB` (optional)  |   The number of Gigabytes to allocate|
| `%` (optional)  |  The percent of total memory to allocate |

###### Specific Parameters for IO
   
| Name             | Description |
| -----            | ----- |
| `Length` (optional)  |  Duration in second of the attack |
| `Directory`  (optional) |   The root directory for the IO attack|
| `Mode`  (optional) |  Do only reads, only writes, or both|

###### Specific Parameters for disk
   
| Name             | Description |
| -----            | ----- |
| `Length`  (optional) |  Duration in second of the attack |
| `Directory`  (optional) |   The root directory for the IO attack|
| ` Volume Percentage` (optional)  |   Percent of Volume to fill (0-100)|



##### 2 State Attacks
##### Parameters for Shutdown
   
| Name             | Description |
| -----            | ----- |
| `Delay`   (optional)   | The number of minutes to delay before shutting down |
| `Reboot` (optional)  |   Indicates the host should reboot after shutting down|
##### Parameters for Time Travel
   
| Name             | Description |
| -----            | ----- |
| `Length`(optional)      | The length of the attack (seconds)|
| `NTP` (optional)  |    Block NTP network communication ( boolean true or false)|
| `Offset` (optional)   |   The offset to the current time (seconds). Can positive or negative|
##### Parameters for Process Killer
   
| Name             | Description |
| -----            | ----- |
| `Length`  (optional)    | The length of the attack (seconds)|
| `Interval` (optional)   |   The number of seconds to delay before kills|
| `Process`    |   The process name to match (allows regex) or the process ID|
| `Group`  (optional) | The group name or ID to match against (name matches only)|
| `User` (optional)  |   The user name or ID to match against (name matches only)|

##### 3 Network Attacks
##### Parameters for blackhole
      
| Name             | Description |
| -----            | ----- |
| `Length`     (optional)  | The length of the attack (seconds)|
| `IP Addresses`  (optional) |   Only impact traffic to these IP addresses Exclude an IP address from impact with a leading '^'|
| `Device`  (optional)  |   Impact traffic over this network interface Defaults to the first device it finds (Ex: eth0)|
| `Hostnames`  (optional)  | Only impact traffic to these hostnames Exclude a host from impact with a leading ^  Value must be of type: URL Default value is "^api.gremlin.com". |
| `Remote Ports` (optional)   |   Impact outgoing and incoming traffic to and from these remote ports Ranges work too: '8080-8085'|
| `Local Ports`  (optional)  |   Impact outgoing and incoming traffic to and from these local ports Ranges work too: '8080-8085'|
##### Parameters for latency
   
| Name             | Description |
| -----            | ----- |
| `Length`  (optional)    | The length of the attack (seconds)|
| `MS`  (optional) |   How long to delay egress packets (millis)Value must be of type: Integer Default value is "100"|
| `IP Addresses`  (optional) |   Only impact traffic to these IP addresses Exclude an IP address from impact with a leading '^'|
| `Device`  (optional)  |   Impact traffic over this network interface Defaults to the first device it finds (Ex: eth0)|
| `Hostnames`  (optional)  | Only impact traffic to these hostnames Exclude a host from impact with a leading ^  Value must be of type: URL Default value is "^api.gremlin.com". |
| `Remote Ports` (optional)   |   Impact outgoing and incoming traffic to and from these remote ports Ranges work too: '8080-8085'|
| `Local Ports`  (optional)  |   Impact outgoing and incoming traffic to and from these local ports Ranges work too: '8080-8085'|

#### Parameters for Packet Loss
   
| Name             | Description |
| -----            | ----- |
| `Length`  (optional)    | The length of the attack (seconds)|
| `Percent`  (optional) |  Percentage of packets to drop (10 is 10%) Value must be of type: Integer Default value is "1".|
| `IP Addresses`  (optional) |   Only impact traffic to these IP addresses Exclude an IP address from impact with a leading '^'|
| `Device`  (optional)  |   Impact traffic over this network interface Defaults to the first device it finds (Ex: eth0)|
| `Hostnames`  (optional)  | Only impact traffic to these hostnames Exclude a host from impact with a leading ^  Value must be of type: URL Default value is "^api.gremlin.com". |
| `Remote Ports` (optional)   |   Impact outgoing and incoming traffic to and from these remote ports Ranges work too: '8080-8085'|
| `Local Ports`  (optional)  |   Impact outgoing and incoming traffic to and from these local ports Ranges work too: '8080-8085'|
#### Parameters for DNS
   
| Name             | Description |
| -----            | ----- |
| `Length`  (optional)    | The length of the attack (seconds)|
| `Device`  (optional)  |   Impact traffic over this network interface Defaults to the first device it finds (Ex: eth0)|
| `IP Addresses`  (optional) |   Only impact traffic to these IP addresses Exclude an IP address from impact with a leading '^'|
| `Protocol`  (optional)  |   Impact traffic only for this protocole .Defaults to all protocols Value must be of type: Enum|



### NeoLoad Set-up

Once installed, how to use in a given NeoLoad project:

1. Create a `Gremlin` User Path.
1. Insert one of the Gremlin custom Action in the `Action` block.
<p align="center"><img src="/screenshot/vu.png" alt="Gremlin User Path" /></p>
1. Add a `Delay` in the  `Action` block between each attack

1. Create a NeoLoad Population Gremlin having only the userPath Gremlin
<p align="center"><img src="/screenshot/population.png" alt="Gremlin Population" /></p>
1. Create a NeoLoad Scenario Using your population and the Gremlin Population
The Gremlin Population would need to be added to your NeoLoad scenario with the following settings :
* Duration : iteration
* Load Policy : Constant : 1 user doing 1 iteration
<p align="center"><img src="/screenshot/scenario.png" alt="Gremlin scenario" /></p>


### Where would you find the details of the attack during the test execution

#### Events
Every single attack will be recorded as an event in NeoLoad Web. 
<p align="center"><img src="/screenshot/events.png" alt="Gremlin events" /></p>

#### Montoring data
Every attacks collecting metrics will report the metrics in the monitoring of NeoLoad
<p align="center"><img src="/screenshot/graph.png" alt="Gremlin graph" /></p>
