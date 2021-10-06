#include <iostream>
#include <future>
#include <mutex>
#include <vector>

using namespace std;

auto v = vector<int>{};
auto mtx = new mutex{}; //mutex asociado al vector v

void thread_1_function(int i)
{
	mtx->lock(); // adquiere el mutex

	v.push_back(i);

	mtx->unlock(); // libera el mutex
}

void thread_2_function()
{
	mtx->lock(); // adquiere el mutex

	cout << v.size() << '\n';

	mtx->unlock(); // libera el mutex
}