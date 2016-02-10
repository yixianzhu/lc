//thread: 1, 2, 1, 1, 3, 4; 冷却时间: 2 time slot，scheduler应该是这样的:1, 2, _, 1, _, _, 1，3, 4，返回9
//用个hashmap存一下每种type最后出现的index，每来一个task如果在map里的话，就根据cool down time更新index，如果不在就添加进去
