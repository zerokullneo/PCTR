#include <future>
#include <iostream>
#include <mutex>
#include <pthread.h>
#include <vector>

using namespace std;

auto push(int thread_idx, vector<int>& v, mutex& mtx) -> void
{
	static auto i = 0;
	while (true)
	{
		lock_guard<mutex> _{mtx};
		if (i >= 10)
			return;
			
		cout << "Thread " << thread_idx << " inserts element " << v.size() << '\n';
		v.push_back(i);
		++i;
	}
}

auto main() -> int
{
	auto data = vector<int>{};
	auto mtx = new mutex{};

	auto f_1 = async(launch::async, [&]{ push(1, data, *mtx); });
	auto f_2 = async(launch::async, [&]{ push(2, data, *mtx); });

	f_1.wait(); // bloqueo hasta que la primera operación asíncrona haya terminado
	f_2.wait(); // bloqueo hasta que la segunda operación asíncrona haya terminado

	return 0;
}