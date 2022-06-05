/*
 * @lc app=leetcode.cn id=478 lang=cpp
 *
 * [478] 在圆内随机生成点
 */
#include <vector>
#include <iostream>
#include <random>
using namespace std;
// @lc code=start
class Solution
{

private:
    double radius;   //半径
    double x_center; //圆心横坐标
    double y_center; //圆心纵坐标
    mt19937 mt_rand{random_device{}()};
    uniform_real_distribution<double> dis;

public:
    Solution(double radius, double x_center, double y_center) : dis(-radius, radius), radius(radius), x_center(x_center), y_center(y_center)
    {
    }

    vector<double> randPoint()
    {

        while (true)
        {
            double x = dis(mt_rand);
            double y = dis(mt_rand);
            if (x * x + y * y <= radius * radius)
            {
                return {x + x_center, y + y_center};
            }
        }
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(radius, x_center, y_center);
 * vector<double> param_1 = obj->randPoint();
 */
// @lc code=end
