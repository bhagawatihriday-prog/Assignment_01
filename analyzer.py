from typing import List, Dict, Set
from functools import reduce
import random
import time

Log = Dict[str, object]


def total_time_per_user(logs: List[Log]) -> Dict[str, float]:
    return reduce(
        lambda acc, log: (
            acc.__setitem__(log["user"], acc.get(log["user"], 0.0) + float(log["duration"])) or acc
        ),
        logs,
        {}
    )


def most_active_users(logs: List[Log], k: int) -> List[str]:
    totals = total_time_per_user(logs)
    return [
        user
        for user, _ in sorted(totals.items(), key=lambda x: x[1], reverse=True)[:k]
    ]


def unique_actions(logs: List[Log]) -> Set[str]:
    return {log["action"] for log in logs}


def generate_logs(n: int) -> List[Log]:
    users = [f"2023{i:03d}" for i in range(50)]
    actions = ["YouTube", "Instagram", "WhatsApp", "Google", "Facebook"]

    return [
        {
            "user": random.choice(users),
            "action": random.choice(actions),
            "duration": random.uniform(1, 60)
        }
        for _ in range(n)
    ]


def complexity_test():
    sizes = [1000, 5000, 10000, 20000]

    for n in sizes:
        logs = generate_logs(n)

        start = time.perf_counter()
        most_active_users(logs, 5)
        end = time.perf_counter()

        print(f"n = {n}, time taken = {end - start:.6f} seconds")


if __name__ == "__main__":

    logs = [
        {"user": "2023001", "action": "YouTube", "duration": 45.5},
        {"user": "2023002", "action": "Instagram", "duration": 30.0},
        {"user": "2023001", "action": "WhatsApp", "duration": 20.0},
        {"user": "2023003", "action": "Google", "duration": 50.0},
        {"user": "2023002", "action": "YouTube", "duration": 25.0},
    ]

    print("Total screen time of each student:")
    print(total_time_per_user(logs))
    print("\nTop 2 most active users:")
    print(most_active_users(logs, 2))
    print("\nSet of all different activities performed by the students:")
    print(unique_actions(logs))

    print("\nComplexity Test:")
    complexity_test()