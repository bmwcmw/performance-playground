performance-playground
======================

## Goal

Compare relative performance of various serialization and deserialization tools.

Here is the list of benchmarked tools:

1. FasterXML's [Jackson JSON](http://wiki.fasterxml.com/JacksonHome)
1. FasterXML's Jackson JSON with [Afterburner](https://github.com/FasterXML/jackson-module-afterburner)
2. Google's [Protocol Buffers](https://developers.google.com/protocol-buffers/)

## Notes

* You will need the Google Protocol Buffers compiler installed.  Additionally, the path for `protoc` is
  hard-coded to `/usr/local/bin/protoc`. If you use Microsoft Windows or have installed the compiler to
  a non-standard location then you will need to update this path in pom.xml.
* Benchmarks are collected via unit tests. Run the "test" lifecycle in order to collect your own
  benchmarks.

## Benchmarks

The following table shows timings for serialization and deserialization of 1,000
TestObject instances populated with random data.  Each batch of 1,000 instances
was performed 100 times in order to calculate average, minimum, and maximum
times as well as variance around the average to gauge how consistent the
serialization and deserialization processes are for the various frameworks.

The latest benchmarks were collected on October 21/23, 2015 using Java 1.8.0_60 and the following platform:

* CPU: i5 4570 3.2-3.6 GHz, 4 cores
* RAM: 8 GB DDR3
* Disk: HDD
* OS: Windows 7

Protobuf 2.6.1 :

### Serialization

| Framework | Average Time (ms) | Min. Time (ms) | Max. Time (ms) | Variance |
| :-------- | ----------------: | -------------: | -------------: | :------- |
| Jackson JSON 2.6.1 | 127 | 123 | 177 | -0,03% / +0,39% |
| Jackson Afterburner JSON 2.6.1 | 124 | 122 | 138 | -0,02% / +0,11% |
| Protocol Buffers 2.6.1 | 43 | 41 | 96 | -0,05% / +1,23% |

### Deserialization

| Framework | Average Time (ms) | Min. Time (ms) | Max. Time (ms) | Variance |
| :-------- | ----------------: | -------------: | -------------: | :------- |
| Jackson JSON 2.6.1 | 240 | 236 | 439 | -0,02% / +0,83% |
| Jackson Afterburner JSON 2.6.1 | 231 | 229 | 252 | -0,01% / +0,09% |
| Protocol Buffers 2.6.1 | 39 | 38 | 79 | -0,03% / +1,03% |

### Compression

| Framework | Uncompressed Size (bytes) | GZip Compressed Size (bytes) | Compression Ratio |
| :-------- | ------------------------: | ---------------------------: | ----------------: |
| Jackson JSON 2.6.1 | 33 388 | 10 | 3338,80 |
| Jackson Afterburner JSON 2.6.1 | 33 342 | 10 | 3334,20 |
| Protocol Buffers 2.6.1 | 12 008 | 10 | 1200,80 |

Protobuf 3.0.0-beta-1 : 

### Serialization

| Framework | Average Time (ms) | Min. Time (ms) | Max. Time (ms) | Variance |
| :-------- | ----------------: | -------------: | -------------: | :------- |
| Jackson JSON 2.6.1 | 131 | 128 | 185 | -0,02% / +0,41% |
| Jackson Afterburner JSON 2.6.1 | 124 | 122 | 139 | -0,02% / +0,12% |
| Protocol Buffers 3.0.0-beta-1 | 43 | 42 | 95 | -0,02% / +1,21% |

### Deserialization

| Framework | Average Time (ms) | Min. Time (ms) | Max. Time (ms) | Variance |
| :-------- | ----------------: | -------------: | -------------: | :------- |
| Jackson JSON 2.6.1 | 244 | 240 | 291 | -0,02% / +0,19% |
| Jackson Afterburner JSON 2.6.1 | 242 | 239 | 272 | -0,01% / +0,12% |
| Protocol Buffers 3.0.0-beta-1 | 38 | 37 | 77 | -0,03% / +1,03% |

### Compression

| Framework | Uncompressed Size (bytes) | GZip Compressed Size (bytes) | Compression Ratio |
| :-------- | ------------------------: | ---------------------------: | ----------------: |
| Jackson JSON 2.6.1 | 33 326 | 10 | 3332,60 |
| Jackson Afterburner JSON 2.6.1 | 33 372 | 10 | 3337,20 |
| Protocol Buffers 3.0.0-beta-1 | 12 001 | 10 | 1200,10 |


The pre-latest benchmarks were collected on June 25, 2015 using Java 1.8.0_40 and the following platform:

* CPU: 2.8 GHz Intel Core i7, 4 cores
* RAM: 16 GB 1600 MHz DDR3
* Disk: Apple SSD
* OS: Mac OS X Yosemite 10.10.3 on MacBook Pro (Retina, 15-inch, Mid 2014)

### Serialization

| Framework | Average Time (ms) | Min. Time (ms) | Max. Time (ms) | Variance |
| :-------- | ----------------: | -------------: | -------------: | :------- |
| Jackson JSON 2.6.0-rc2 | 130 | 122 | 169 | -0.06% / +0.30% |
| Jackson Afterburner JSON 2.6.0-rc2 | 118 | 115 | 131 | -0.03% / +0.11% |
| Protocol Buffers 3.0.0-alpha-3 | 41 | 38 | 103 | -0.07% / +1.51% |

### Deserialization

| Framework | Average Time (ms) | Min. Time (ms) | Max. Time (ms) | Variance |
| :-------- | ----------------: | -------------: | -------------: | :------- |
| Jackson JSON 2.6.0-rc2 | 184 | 179 | 256 | -0.03% / +0.39% |
| Jackson Afterburner JSON 2.6.0-rc2 | 179 | 170 | 233 | -0.05% / +0.30% |
| Protocol Buffers 3.0.0-alpha-3 | 36 | 34 | 72 | -0.06% / +1.00% |

### Compression

Besides time spent converting data, some analysis was done on the binary data
produced after serialization to see if one framework produced significantly
smaller data sets either before or after compression.

| Framework | Uncompressed Size (bytes) | GZip Compressed Size (bytes) | Compression Ratio |
| :-------- | ------------------------: | ---------------------------: | ----------------: |
| Jackson JSON 2.6.0-rc2 | 33,372 | 13,054 | 2.56 |
| Jackson Afterburner JSON 2.6.0-rc2 | 33,364 | 13,084 | 2.55 |
| Protocol Buffers 3.0.0-alpha-3 | 12,005 | 10,819 | 1.11 |
