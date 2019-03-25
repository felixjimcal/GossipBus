# GossipBus kata with TDD
## Getting Started

Bus drivers like to gossip, everyone knows that. And bus drivers can gossip when they end up at the same stop. So now we are going to calculate after how many stops all the bus drivers know all the gossips. You will be given a number of bus routes that the drivers follow. Each driver starts with one gossip. Each route is appointed to 1 driver. When 2 or more drivers are at the same stop (even if it is the start), they can exchange all the gossips they know. A route looks like this: 1 2 3 4 and is repeated over the whole day like this 1 2 3 4 1 2 3 4 1 2 3 … If a driver starts and stops at the same stop then that is also repeated. All drivers take 1 minute to go from one stop to another and the gossip exchange happens instantly. All drivers drive 8 hours a day so you have a maximum of 480 minutes to get all the gossiping around.

### Example 
You will receive all the driver routes. Not all drivers have a route of the same length

Example 1:

3 1 2 3

3 2 3 1

4 2 3 4 5

Example 2:

2 1 2

5 2 8

Output Description

The number of stops it takes to have all drivers on board with the latest gossips. If there is even one driver who does not have all the gossips by the end of the day, the answer is never.

Example 1: 5

Example 2: never
### Prerequisites

You need an IDE to run the test in Java

## Running the tests

To run the test just open it with the IDE and press "run all test" button

### Break down into end to end tests
The test are done with a battery of test with JUnitParameters, feel free tho change the entry value and expected answer.

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Felix Jimenez Calvo** - *Initial work* - [felixjimcal](https://github.com/felixjimcal)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* The people who challenge me to improve my knowledge
