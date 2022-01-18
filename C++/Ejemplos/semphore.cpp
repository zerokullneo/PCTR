#include <iostream>
#include <thread>
#include <chrono>
#include <semaphore>

using namespace std;

binary_semaphore
	smphSignalMainToThread(0),
	smphSignalThreadToMain(0);
 
void ThreadProc(){	
	smphSignalMainToThread.acquire();
	cout << "[thread] Got the signal\n";
	using namespace literals;
	this_thread::sleep_for(1s);
	cout << "[thread] Send the signal\n";
	smphSignalThreadToMain.release();
}
 
int main(){
	thread thrWorker(ThreadProc);
	cout << "[main] Send the signal\n";
	smphSignalMainToThread.release();
	smphSignalThreadToMain.acquire();
	cout << "[main] Got the signal\n";
	thrWorker.join();
}